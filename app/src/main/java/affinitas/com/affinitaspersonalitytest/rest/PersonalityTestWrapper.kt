package affinitas.com.affinitaspersonalitytest.rest

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 8/31/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class PersonalityTestWrapper(@JsonProperty("categories") val categories: List<String>,
                                  @JsonProperty("questions") val questions: List<JsonQuestion>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonQuestion(@JsonProperty("question") val question: String,
                        @JsonProperty("category") val category: String,
                        @JsonProperty("question_type") val questionType: JsonQuestionType)

@JsonIgnoreProperties(ignoreUnknown = true)
data class JsonQuestionType(@JsonProperty("type") val type: String,
                            @JsonProperty("options") val options: List<String>)