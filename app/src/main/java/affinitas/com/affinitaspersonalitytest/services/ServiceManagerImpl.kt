package affinitas.com.affinitaspersonalitytest.services

import android.content.Context

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 */
class ServiceManagerImpl(val databaseService: DatabaseService): ServiceManager {
    override fun initializeServices(context: Context) {
        databaseService.initializeDatabase(context)
    }

}