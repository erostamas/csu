package com.erostamas.csu.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.erostamas.csu.R;
import com.erostamas.csu.ScannedBarcodeActivity;
import com.erostamas.csu.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    Button btnTakePicture, btnScanBarcode;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        btnTakePicture = root.findViewById(R.id.btnTakePicture);
        btnScanBarcode = root.findViewById(R.id.btnScanBarcode);
        btnTakePicture.setOnClickListener(this);
        btnScanBarcode.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //case R.id.btnTakePicture:
            //    startActivity(new Intent(getActivity(), PictureBarcodeActivity.class));
            //    break;
            case R.id.btnScanBarcode:
                startActivity(new Intent(getActivity(), ScannedBarcodeActivity.class));
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}