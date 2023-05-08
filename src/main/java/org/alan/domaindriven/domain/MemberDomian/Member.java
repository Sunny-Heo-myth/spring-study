package org.alan.domaindriven.domain.MemberDomian;

public class Member {

    private MemberId memberId;
    private Password password;

    public void changePassword(String currentPassword, String newPassword) throws PasswordNotMatchException {
        if (!password.match(currentPassword)) {
            throw new PasswordNotMatchException();
        }
        this.password = new Password(newPassword);
    }
}
