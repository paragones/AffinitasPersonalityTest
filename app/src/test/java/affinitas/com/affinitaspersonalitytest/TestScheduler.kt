package affinitas.com.affinitaspersonalitytest

import affinitas.com.affinitaspersonalitytest.schedulers.ThreadScheduler
import rx.Observable
import rx.schedulers.Schedulers

class TestScheduler() : ThreadScheduler {
    override fun <T> compose(): Observable.Transformer<T, T> {
        return Observable.Transformer<T, T> { observable ->
            observable.observeOn(Schedulers.immediate())
        }
    }
}