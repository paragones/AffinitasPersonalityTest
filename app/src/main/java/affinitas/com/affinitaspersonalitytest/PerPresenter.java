package affinitas.com.affinitaspersonalitytest;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memoized in the
 * correct component.
 * @see <a href="https://github.com/google/dagger/blob/master/examples/android-activity-graphs/src/main/java/com/example/dagger/activitygraphs/PerActivity.java">Original source from dagger project</a>
 */
@Scope
@Retention(RUNTIME)
public @interface PerPresenter {
}
