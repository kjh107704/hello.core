package hello.core.member;

public class Member {

    private Long id;
    private Long name;
    private Enum grade;

    // cmd+N 눌러서 Constructor로 넣고자 하는 멤버변수들 선택하면 뿅 만들어짐
    public Member(Long id, Long name, Enum grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // cmd+N 눌러서 getter/setter도 만들기 가능
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Enum getGrade() {
        return grade;
    }

    public void setGrade(Enum grade) {
        this.grade = grade;
    }
}
