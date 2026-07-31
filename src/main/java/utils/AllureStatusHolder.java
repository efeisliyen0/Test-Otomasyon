package utils;

public class AllureStatusHolder {

    private static final ThreadLocal<Boolean> failed = ThreadLocal.withInitial(() -> false);

    public static void reset() {
        failed.set(false);
    }

    public static void markFailed() {
        failed.set(true);
    }

    public static boolean isFailed() {
        return failed.get();
    }
}