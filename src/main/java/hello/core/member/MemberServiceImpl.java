package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 가입을 하고 사람을 찾고 하려면 MemberRepository interface가 필요함
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
