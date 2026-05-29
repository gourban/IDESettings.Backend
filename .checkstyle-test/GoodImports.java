package co.gourban.example;

import co.gourban.example.other.Helper;

import java.util.List;
import jakarta.servlet.Servlet;
import javax.annotation.Nullable;

import com.wundermobility.lib.Thing;
import eu.gourban.lib.Util;
import org.springframework.stereotype.Service;

/**
 * Layout enforced by goUrban_v3 (CustomImportOrder): the java/jakarta/javax family is one
 * contiguous group (no blank line between the three), with blank lines separating it from the
 * same-package group above and the third-party group below. The java -> jakarta -> javax order
 * is produced by the IntelliJ codestyle. This fixture must produce NO [CustomImportOrder] violation.
 */
@Service
public class GoodImports {
    private final Helper helper = null;
    private final List<String> values = null;
    private final Servlet servlet = null;
    private final Thing thing = null;
    private final Util util = null;

    @Nullable
    Object value() {
        return null;
    }
}
