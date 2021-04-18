import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

        class RutTest {

            Rut rut;

            @BeforeEach
            void setUp() {

            }

            @AfterEach
            void tearDown() {
                
            }

            @Test
            @DisplayName("Test para verificar que el rut esté bien escrito")
            void validarRut() {
                boolean s = Rut.validarRut("20.048.080-K");
                boolean rut = true;
                assertEquals(rut, s);
            }

            @Test
            @DisplayName("Test para verificar que el digito verificador sea valido")
            void validarVerificador() {

                boolean s = Rut.validarVerificador("20048080k");
                boolean rut = false;
            }
}