package com.ideator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class ReportFragment extends Fragment {

    private EditText mEditTypeIncident;

    private EditText mEditWhoIncident;

    private EditText mEditAusState;

    private EditText mEditAddLocIncident;

    private EditText mEditWhenIncident;

    private EditText mEditOffenderName;

    private EditText mEditOffenderAddress;

    private EditText mEditOffenderGender;

    private EditText mEditOffenderEyeColor;

    private EditText mEditOffenderHairColor;

    private EditText mEditOffenderOther;

    private EditText mEditOffenderApperence;

    private EditText mEditOffenderHeight;

    private EditText mEditOffenderAnythingElse;

    private EditText mEditWhatHappened;

    private EditText mEditToldAnyone;

    private EditText mEditPhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);


         mEditTypeIncident = (EditText) view.findViewById(R.id.edit_type_of_incident);

         mEditWhoIncident = (EditText) view.findViewById(R.id.edit_who_did_the_incident_happen_to);

         mEditAusState = (EditText) view.findViewById(R.id.edit_australia_state_or_territory);

         mEditAddLocIncident = (EditText) view.findViewById(R.id.edit_address_or_location_of_the_incident);

         mEditWhenIncident = (EditText) view.findViewById(R.id.edit_when_the_incident_took_place);

         mEditOffenderName = (EditText) view.findViewById(R.id.edit_effender_name);

         mEditOffenderAddress = (EditText) view.findViewById(R.id.edit_effender_address);

         mEditOffenderGender = (EditText) view.findViewById(R.id.edit_effender_gender);

         mEditOffenderEyeColor = (EditText) view.findViewById(R.id.edit_effender_eye_color);

         mEditOffenderHairColor = (EditText) view.findViewById(R.id.edit_effender_hair_color);

         mEditOffenderOther = (EditText) view.findViewById(R.id.edit_other);

         mEditOffenderApperence = (EditText) view.findViewById(R.id.edit_offender_appearance);

         mEditOffenderHeight = (EditText) view.findViewById(R.id.edit_offender_height);

         mEditOffenderAnythingElse = (EditText) view.findViewById(R.id.edit_remember_anything_else_offender);

         mEditWhatHappened = (EditText) view.findViewById(R.id.edit_what_happened);

         mEditToldAnyone = (EditText) view.findViewById(R.id.edit_told_anyone);

         mEditPhoto = (EditText) view.findViewById(R.id.edit_photo);
                
        return view;

    }


}
