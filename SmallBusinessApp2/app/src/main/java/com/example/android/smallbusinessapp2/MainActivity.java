package com.example.android.smallbusinessapp2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the edit event name field is filled.
     */
    public void EventNameField(Editable insertEventName) {
        EditText editEventName = (EditText) findViewById(R.id.event_name_view);
        String eventName = editEventName.getText().toString();
    }

    /**
     * This method is called when the email field is filled.
     */
    public void EventEmailField(Editable insertEventEmail) {
        EditText editEventEmail = (EditText) findViewById(R.id.event_email_view);
        String eventEmail = editEventEmail.getText().toString();
    }
    /**
     * This method is called when the interests field is filled.
     */
    public void ContactPersonField(Editable insertContactPerson) {
        EditText editContactPerson = (EditText) findViewById(R.id.contact_person_view);
        String contactPerson = editContactPerson.getText().toString();
    }
    /**
     * This method is called when the registration button is clicked.
     */
    public void eventRegistration(View view) {
        EditText editEventName = (EditText) findViewById(R.id.event_name_view);
        String eventName = editEventName.getText().toString();
        EditText editEventEmail = (EditText) findViewById(R.id.event_email_view);
        String eventEmail = editEventEmail.getText().toString();
        EditText editContactPerson = (EditText) findViewById(R.id.contact_person_view);
        String contactPerson = editContactPerson.getText().toString();
        String eventRegistrationForm;
        eventRegistrationForm = createEventRegistrationSummary(eventName, eventEmail, contactPerson);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: dinagdavis@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Registration for " + eventName);
        intent.putExtra(Intent.EXTRA_TEXT, eventRegistrationForm);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(eventRegistrationForm);
    }


    /**
     * creates a registration summary
     *@param eventName returns name from edit text field
     * @param eventEmail returns email from the edit email field
     * @param contactPerson returns the list of interests from the edit interests field
     * @return text summary
     */
    private String createEventRegistrationSummary(String eventName, String eventEmail, String contactPerson) {
        String eventRegistrationForm = "Event Name: " + eventName;
        eventRegistrationForm += "\nEvent Email Address: " + eventEmail;
        eventRegistrationForm += "\nEvent Contact Person: " + contactPerson;
        eventRegistrationForm += "\n" + "Thank you for registering your event here!";
        return eventRegistrationForm;
    }

    /**
     * This method is called when the edit text field is filled.
     */
    public void NameField(Editable insertName) {
        EditText editName = (EditText) findViewById(R.id.name_view);
        String name = editName.getText().toString();
    }

    /**
     * This method is called when the email field is filled.
     */
    public void EmailField(Editable insertemail) {
        EditText editEmail = (EditText) findViewById(R.id.email_view);
        String email = editEmail.getText().toString();
    }
    /**
     * This method is called when the interests field is filled.
     */
    public void InterestsField(Editable insertInterests) {
        EditText editInterests = (EditText) findViewById(R.id.interests_view);
        String interests = editInterests.getText().toString();
    }
    /**
     * This method is called when the registration button is clicked.
     */
    public void registration(View view) {
        EditText editName = (EditText) findViewById(R.id.name_view);
        String name = editName.getText().toString();
        EditText editEmail = (EditText) findViewById(R.id.email_view);
        String email = editEmail.getText().toString();
        EditText editInterests = (EditText) findViewById(R.id.interests_view);
        String interests = editInterests.getText().toString();
        String registrationForm;
        registrationForm = createRegistrationSummary(name, email, interests);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: dinagdavis@gmail.com")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Registration for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, registrationForm);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(registrationForm);
    }


    /**
     * creates a registration summary
     *@param name returns name from edit text field
     * @param email returns email from the edit email field
     * @param interests returns the list of interests from the edit interests field
     * @return text summary
     */
    private String createRegistrationSummary(String name, String email, String interests) {
        String registrationForm = "Name: " + name;
        registrationForm += "\nEmail Address: " + email;
        registrationForm += "\nInterests: " + interests;
        registrationForm += "\n" + "Thank you for registering!";
        return registrationForm;
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView registrationSummaryTextView = (TextView) findViewById(R.id.registration_summary_text_view);
        registrationSummaryTextView.setText(message);
    }

    /**
     * This method resets the app.
     */
    public void clearForm(View view) {
        Intent MainActivity = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        MainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(MainActivity);
    }
}


