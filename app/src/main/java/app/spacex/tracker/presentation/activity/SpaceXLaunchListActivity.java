package app.spacex.tracker.presentation.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import app.spacex.tracker.R;
import app.spacex.tracker.databinding.ActivitySpacexLaunchListBinding;
import app.spacex.tracker.presentation.DefaultServiceLocator;
import app.spacex.tracker.presentation.viewmodel.SpaceXLaunchViewModel;
import app.spacex.tracker.presentation.viewmodel.SpaceXViewModelFactory;

public class SpaceXLaunchListActivity extends AppCompatActivity {

    private ActivitySpacexLaunchListBinding binding;
    private SpaceXLaunchViewModel viewModel;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_spacex_launch_list);

        /**
         * Create a viewmodel factory to pass the parameter
         * In this case we want to pass the use case class
         * **/
        SpaceXViewModelFactory viewModelFactory = new SpaceXViewModelFactory(
                DefaultServiceLocator.getInstance(getApplication()));
        viewModel = viewModelFactory.create(SpaceXLaunchViewModel.class);

        /**
         * Call API to get Launch List
         * **/
        viewModel.getLaunchList();

    }
}
