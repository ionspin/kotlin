/*
 * Copyright 2010-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */

#include "Clock.hpp"

namespace kotlin::test_support {

// Clock that is manually advanced (cannot go backwards). For testing purposes.
// TODO: Should be reset at the start of each test.
class manual_clock : public internal::ClockWaitImpl<manual_clock> {
public:
    using duration = nanoseconds;
    using rep = duration::rep;
    using period = duration::period;
    using time_point = std::chrono::time_point<manual_clock>;

    // Steady because it cannot go backwards.
    static constexpr bool is_steady = true;

    static time_point now() noexcept { return now_.load(); }

    using internal::ClockWaitImpl<manual_clock>::sleep_until;

    template <typename Rep, typename Period>
    static void sleep_until(std::chrono::time_point<manual_clock, std::chrono::duration<saturating<Rep>, Period>> until) {
        time_point before = now();
        while (before < until) {
            now_.compare_exchange_weak(before, until);
        }
    }

    static std::optional<time_point> pending() noexcept {
        std::unique_lock guard(pendingWaitsMutex_);
        auto it = pendingWaits_.begin();
        if (it == pendingWaits_.end()) {
            return std::nullopt;
        }
        return *it;
    }

    // Should be done before the timer is used (in the beginning of the test, for example).
    static void reset(time_point start = time_point::min()) noexcept {
        std::unique_lock guard(pendingWaitsMutex_);
        RuntimeAssert(pendingWaits_.empty(), "To reset, there must not be any pending waits");
        now_ = start;
    }

private:
    friend class internal::ClockWaitImpl<manual_clock>;

    // Use non-saturating type here, because step may be fed into the standard library.
    static inline constexpr auto wait_step = std::chrono::microseconds(1);

    class PendingWaitRegistration : private Pinned {
    public:
        ~PendingWaitRegistration() noexcept {
            std::unique_lock guard(pendingWaitsMutex_);
            pendingWaits_.erase(it_);
        }

    private:
        friend class manual_clock;

        explicit PendingWaitRegistration(KStdOrderedMultiset<time_point>::iterator it) noexcept : it_(it) {}

        KStdOrderedMultiset<time_point>::iterator it_;
    };

    template <typename Rep, typename Period>
    static PendingWaitRegistration addPendingWait(
            std::chrono::time_point<manual_clock, std::chrono::duration<saturating<Rep>, Period>> until) {
        std::unique_lock guard(pendingWaitsMutex_);
        auto it = pendingWaits_.insert(until);
        return PendingWaitRegistration(it);
    }

    static std::atomic<time_point> now_;
    static std::mutex pendingWaitsMutex_;
    static KStdOrderedMultiset<time_point> pendingWaits_;
};

} // namespace test_support
