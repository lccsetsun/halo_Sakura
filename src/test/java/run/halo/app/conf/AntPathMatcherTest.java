package run.halo.app.conf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.AntPathMatcher;

import javax.annotation.security.RunAs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ant path matcher test.
 *
 * @author johnniang
 */
@SpringBootTest
class AntPathMatcherTest {

    final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Test
    void matchTest() {
        assertFalse(pathMatcher.match("/admin/?*/**", "/admin"));
        assertFalse(pathMatcher.match("/admin/?*/**", "/admin/"));
        System.out.println("======");
        assertTrue(pathMatcher.match("/admin/?*/**", "/admin/index.html"));
        assertTrue(pathMatcher.match("/admin/?*/**", "/admin/index.html/more"));
    }
}
