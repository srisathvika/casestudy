package Service;

import Utility.Member;
import java.sql.SQLException;
import java.util.List;

import Dao.MemberDAO;

public class MemberService {
    private MemberDAO memberDAO = new MemberDAO();

    public void registerMember(Member member) throws Exception {
        if (member.getName() == null || member.getName().trim().isEmpty())
            throw new IllegalArgumentException("Name is required");
        if (member.getEmail() == null || member.getEmail().trim().isEmpty())
            throw new IllegalArgumentException("Email is required");
        if (member.getAddress() == null || member.getAddress().trim().isEmpty())
            throw new IllegalArgumentException("Address is required");

        memberDAO.addMember(member);
    }

    public List<Member> getAllMembers() throws SQLException {
        return memberDAO.getAllMembers();
    }

    public void updateMember(Member member) throws Exception {
        if (member.getMemberId() <= 0)
            throw new IllegalArgumentException("Invalid member ID");
        memberDAO.updateMember(member);
    }

    public Member getMemberById(int memberId) throws SQLException {
        return memberDAO.getMemberById(memberId);
    }
}