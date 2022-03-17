package com.madthreed.polls_api.util;

import com.madthreed.polls_api.dto.ChoiceRequest;
import com.madthreed.polls_api.model.Choice;

public class ChoiceMapper {

    public static Choice mapChoiceRequestToChoice(ChoiceRequest choiceRequest) {
        Choice choice = new Choice();
        choice.setText(choiceRequest.getText());

        return choice;
    }
}
