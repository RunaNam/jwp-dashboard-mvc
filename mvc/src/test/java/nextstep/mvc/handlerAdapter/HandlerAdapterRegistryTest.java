package nextstep.mvc.handlerAdapter;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.mvc.controller.tobe.HandlerExecution;
import nextstep.mvc.exception.ServletException;

class HandlerAdapterRegistryTest {

    @Test
    @DisplayName("적절한 handlerAdapter이 없을 시 에러를 발생시킨다.")
    void getHandlerAdapterError() {
        HandlerAdapterRegistry handlerAdapterRegistry = new HandlerAdapterRegistry();

        HandlerExecution handlerExecution = mock(HandlerExecution.class);

        assertThatThrownBy(() -> handlerAdapterRegistry.getHandlerAdapter(handlerExecution))
            .isInstanceOf(ServletException.class)
            .hasMessage("Handler Adapter를 찾을 수 없습니다.");
    }
}