package com.ideator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 * s
 */
public class ReportFragment extends Fragment {

    private Spinner mEditTypeIncident;

    private Spinner mEditWhoIncident;

    private Spinner mEditAusState;

    private EditText mEditAddLocIncident;

    private EditText mEditWhenIncident;

    private EditText mEditOffenderName;

    private EditText mEditOffenderAddress;

    private Spinner mEditOffenderGender;

    private Spinner mEditOffenderEyeColor;

    private Spinner mEditOffenderHairColor;

    private EditText mEditOffenderOther;

    private Spinner mEditOffenderApperence;

    private EditText mEditOffenderHeight;

    private EditText mEditOffenderAnythingElse;

    private EditText mEditWhatHappened;

    private Spinner mEditToldAnyone;

    private Button mButtonPhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

         mEditTypeIncident = (Spinner) view.findViewById(R.id.spinner_type_of_incident);

         mEditWhoIncident = (Spinner) view.findViewById(R.id.spinner_who_the_incident_happened_to);

         mEditAusState = (Spinner) view.findViewById(R.id.spinner_australia_start_or_territory);

         mEditAddLocIncident = (EditText) view.findViewById(R.id.edit_address_or_location_of_the_incident);

         mEditWhenIncident = (EditText) view.findViewById(R.id.edit_when_the_incident_took_place);

         mEditOffenderName = (EditText) view.findViewById(R.id.edit_offender_name);

         mEditOffenderAddress = (EditText) view.findViewById(R.id.edit_offender_address);

         mEditOffenderGender = (Spinner) view.findViewById(R.id.spinner_offender_gender);

         mEditOffenderEyeColor = (Spinner) view.findViewById(R.id.spinner_offender_eye_color);

         mEditOffenderHairColor = (Spinner) view.findViewById(R.id.spinner_offender_hair_color);

         mEditOffenderOther = (EditText) view.findViewById(R.id.edit_other);

         mEditOffenderApperence = (Spinner) view.findViewById(R.id.spinner_offender_appearance);

         mEditOffenderHeight = (EditText) view.findViewById(R.id.edit_offender_height);

         mEditOffenderAnythingElse = (EditText) view.findViewById(R.id.edit_remember_anything_else_offender);

         mEditWhatHappened = (EditText) view.findViewById(R.id.edit_what_happened);

         mEditToldAnyone = (Spinner) view.findViewById(R.id.spinner_told_anyone);

         mButtonPhoto = (Button) view.findViewById(R.id.button_photo);
                
        return view;

    }


}
