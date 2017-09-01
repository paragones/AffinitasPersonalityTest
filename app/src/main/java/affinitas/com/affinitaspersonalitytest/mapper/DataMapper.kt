package affinitas.com.affinitaspersonalitytest.mapper

interface DataMapper<T, U> {
    fun transform(input: T) : U
}