package affinitas.com.affinitaspersonalitytest.config.modules

import affinitas.com.affinitaspersonalitytest.schedulers.ObserveOnScheduler
import affinitas.com.affinitaspersonalitytest.schedulers.ThreadScheduler
import dagger.Module
import dagger.Provides
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/2/2017.
 * Copyright © 2017 Dojo Madness GmbH. All rights reserved.
 */
@Module
class ExecutorsModule {
    private val postExecutionThread = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    fun provideObserveExecutor(): ThreadScheduler = ObserveOnScheduler(postExecutionThread)
}