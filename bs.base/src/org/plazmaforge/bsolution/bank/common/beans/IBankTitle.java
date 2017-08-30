package org.plazmaforge.bsolution.bank.common.beans;

import org.plazmaforge.bsolution.partner.common.beans.IPartnerTitle;

public interface IBankTitle extends IPartnerTitle {

    String getBic();
    
    void setBic(String bic);
    
    String getCorrespondentAccount();
    
    void setCorrespondentAccount(String correspondentAccount);
}
