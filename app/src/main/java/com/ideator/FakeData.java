package com.ideator;

import android.graphics.drawable.Drawable;

import java.util.Date;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class FakeData {
    private Drawable postPicture;
    private Drawable profilePicture;
    private Date date;
    private String post;
    private String firstName;
    private String lastName;

    public FakeData(Drawable postPicture, Drawable profilePicture, Date date, String post, String firstName, String lastName) {
        this.postPicture = postPicture;
        this.profilePicture = profilePicture;
        this.date = date;
        this.post = post;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Drawable getPostPicture() {
        return postPicture;
    }

    public Drawable getProfilePicture() {
        return profilePicture;
    }

    public Date getDate() {
        return date;
    }

    public String getPost() {
        return post;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
