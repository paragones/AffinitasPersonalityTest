package affinitas.com.affinitaspersonalitytest.repositories

import io.realm.annotations.PrimaryKey
import io.realm.RealmObject



/**
 * AffinitasPersonalityTest
 *
 * Created by Paul Aragones on 9/1/2017.
 * Copyright © 2017 Dojo Madness GmbH. All rights reserved.
 */
open class RealmAnswerKey : RealmObject() {
    @PrimaryKey
    var questionItemId: Int = 0
    var optionSelected: Int = 0
}