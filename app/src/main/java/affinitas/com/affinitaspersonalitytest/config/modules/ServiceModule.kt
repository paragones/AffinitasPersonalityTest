package affinitas.com.affinitaspersonalitytest.config.modules

import affinitas.com.affinitaspersonalitytest.services.DatabaseService
import affinitas.com.affinitaspersonalitytest.services.RealmDatabase
import affinitas.com.affinitaspersonalitytest.services.ServiceManager
import affinitas.com.affinitaspersonalitytest.services.ServiceManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 */

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideServiceManager(databaseService: DatabaseService): ServiceManager
            = ServiceManagerImpl(databaseService)

    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService
            = RealmDatabase()
}