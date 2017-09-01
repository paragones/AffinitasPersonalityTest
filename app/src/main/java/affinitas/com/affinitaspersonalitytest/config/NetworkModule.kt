package affinitas.com.affinitaspersonalitytest.config

import affinitas.com.affinitaspersonalitytest.BuildConfig
import affinitas.com.affinitaspersonalitytest.rest.QuestionnaireRest
import android.net.Uri
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/30/2017.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideQuestionnaireRest(retrofit: Retrofit): QuestionnaireRest = retrofit.create(QuestionnaireRest::class.java)

    @Provides
    @Singleton
    fun provideDefaultRestAdapter(objectMapper: ObjectMapper): Retrofit = defaultRetrofit(defaultConverter(objectMapper)).build()

    @Provides
    @Singleton
    fun provideDefaultJacksonObjectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper
                .registerModule(KotlinModule())
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val simpleModule = SimpleModule()
        simpleModule
                .addSerializer(Uri::class.java, ToStringSerializer())
        objectMapper.registerModule(simpleModule)

        return objectMapper
    }

    @Provides
    @Singleton
    fun defaultConverter(objectMapper: ObjectMapper): Converter.Factory = JacksonConverterFactory.create(objectMapper)

    fun defaultRetrofit(converter: Converter.Factory): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(converter)
    }
}