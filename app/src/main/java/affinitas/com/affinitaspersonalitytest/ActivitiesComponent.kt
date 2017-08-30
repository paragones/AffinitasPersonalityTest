package affinitas.com.affinitaspersonalitytest

import dagger.Component

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

@PerPresenter
@Component
interface ActivitiesComponent {
    fun inject(activity: MainActivity)
}