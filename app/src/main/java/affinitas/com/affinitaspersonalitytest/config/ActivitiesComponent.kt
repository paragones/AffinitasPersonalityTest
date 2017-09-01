package affinitas.com.affinitaspersonalitytest.config

import affinitas.com.affinitaspersonalitytest.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

@Singleton
@Component(modules = arrayOf(NetworkModule::class, ActivityModule::class))
interface ActivitiesComponent {
    fun inject(activity: MainActivity)
}