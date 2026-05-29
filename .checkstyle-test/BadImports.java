package co.gourban.example;

import java.util.List;
import javax.annotation.Nullable;

import com.wundermobility.lib.Thing;
import jakarta.servlet.Servlet;

/**
 * jakarta is left in the third-party group instead of being grouped with java/javax.
 * goUrban_v3 requires jakarta to sit in the standard JDK/EE group, so this fixture MUST produce
 * a [CustomImportOrder] violation. (Note: the order *within* the java family is maintained by the
 * IntelliJ codestyle, not enforced by CheckStyle - so this fixture deliberately tests grouping.)
 */
public class BadImports {
    private final List<String> values = null;
    private final Servlet servlet = null;
    private final Thing thing = null;

    @Nullable
    Object value() {
        return null;
    }
}
