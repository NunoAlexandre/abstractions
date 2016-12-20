package com.nunoalexandre.abstractions.trycatch;
import com.nunoalexandre.abstractions.interfaces.FallibleAction;
import com.nunoalexandre.abstractions.interfaces.FallibleRunnable;
import java.util.Optional;
import java.util.function.Consumer;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class Try {

    public static <T, E> Optional<T> toGet(FallibleAction<T, E> action) {
        try {
            return ofNullable(action.result());
        } catch (Exception e) {
            return empty();
        }
    }

    public static void toRun(FallibleRunnable runnable, Runnable ifFail) {
        try {
            runnable.run();
        } catch (Exception e) {
            ifFail.run();
        }
    }

    public static void toRun(FallibleRunnable runnable, Consumer<Exception> ifFail) {
        try {
            runnable.run();
        } catch (Exception e) {
            ifFail.accept(e);
        }
    }
}