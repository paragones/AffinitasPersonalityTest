package affinitas.com.affinitaspersonalitytest.config.components

import affinitas.com.affinitaspersonalitytest.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ActivitiesComponent {
    fun inject(activity: MainActivity)
}