package affinitas.com.affinitaspersonalitytest.schedulers

import rx.Observable
import rx.Scheduler

class ObserveOnScheduler(val postExecutionThread: Scheduler) : ThreadScheduler {
    override fun <T> compose(): Observable.Transformer<T, T> {
        return Observable.Transformer<T, T> { observable ->
            observable.observeOn(postExecutionThread)
        }
    }
}