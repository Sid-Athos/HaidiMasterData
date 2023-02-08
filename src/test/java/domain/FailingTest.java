package domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FailingTest {

    @Test
    public void shouldFail() {
        Assert.assertTrue(true);
    }
}
