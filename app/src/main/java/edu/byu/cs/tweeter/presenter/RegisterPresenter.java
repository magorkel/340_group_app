package edu.byu.cs.tweeter.presenter;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;

import edu.byu.cs.tweeter.model.service.LoginService;
import edu.byu.cs.tweeter.model.service.RegisterService;
import edu.byu.cs.tweeter.model.service.request.RegisterRequest;
import edu.byu.cs.tweeter.model.service.response.RegisterResponse;

public class RegisterPresenter
{
    private final View view;

    /**
     * The interface by which this presenter communicates with it's view.
     */
    public interface View {
        // If needed, specify methods here that will be called on the view in response to model updates
    }

    /**
     * Creates an instance.
     *
     * @param view the view for which this class is the presenter.
     */
    public RegisterPresenter(RegisterPresenter.View view) {
        this.view = view;
    }

    /**
     * Makes a login request.
     *
     * @param registerRequest the request.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public RegisterResponse register(RegisterRequest registerRequest) throws IOException
    {
        RegisterService registerService = getRegisterService();
        return registerService.register(registerRequest);
    }

    //This is for Mockito Testing
    RegisterService getRegisterService() {
        return new RegisterService();
    }
}
