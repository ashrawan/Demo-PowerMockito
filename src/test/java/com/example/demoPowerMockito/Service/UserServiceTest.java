package com.example.demoPowerMockito.Service;

import com.example.demoPowerMockito.ServiceImpl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserServiceImpl.class)
public class UserServiceTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testPrivateMethod() throws Exception{

        UserServiceImpl userServiceImplSpy = PowerMockito.spy(new UserServiceImpl());
        when(userServiceImplSpy, "getSome", anyInt(), anyInt()). thenReturn(30);
        assertEquals(30, userServiceImplSpy.getSecret());
    }

    @Test
    public void testPublicMethod() throws Exception{

        UserServiceImpl userServiceImplMock = mock(UserServiceImpl.class);
        when(userServiceImplMock.getPublicValue()).thenReturn("Hello");
        assertEquals("Hello", userServiceImplMock.getPublicValue());
    }

    @Test
    public void testConstructor() throws Exception{

        UserServiceImpl userServiceImplMock = mock(UserServiceImpl.class);
        whenNew(UserServiceImpl.class).withNoArguments().thenReturn(userServiceImplMock);
        UserServiceImpl userServiceImp = new UserServiceImpl();
        verifyNew(UserServiceImpl.class).withNoArguments();
    }

    @Test
    public void testStaticMethod(){

        mockStatic(UserServiceImpl.class);
        when(UserServiceImpl.getClassCode()).thenReturn("User000");
        assertEquals("User000", UserServiceImpl.getClassCode());
    }

    @Test
    public void testFinalMethod() throws Exception{

        UserServiceImpl userServiceImplMock = PowerMockito.mock(UserServiceImpl.class);
        when(userServiceImplMock.getInfo()).thenReturn("final method");
        assertEquals("final method", userServiceImplMock.getInfo());
    }
}
