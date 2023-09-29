package version4;
public class Name {
    private String lastName;
    private String firstName;
    private String middleName;

    public Name() {
    }

    public Name(String lastName) {
        this.lastName = lastName;
    }

    public Name(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Name(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public static Name wPrefix(Name fullName, String prefix) {
        return new Name(String.format("%s %s", prefix, fullName));
    }

    public static Name wSuffix(Name fullName, String suffix) {
        return new Name(String.format("%s %s", fullName, suffix));
    }

    public static Name wSuffixandPrefix(Name fullName, String prefix, String suffix) {
        return new Name(String.format("%s %s %s", prefix, fullName, suffix));
    }

    @Override
    public String toString() {
        if (firstName == null) {
            return String.format("%s", lastName);
        }

        if (middleName == null) {
            return String.format("%s,%s", lastName, firstName);
        }

        return String.format("%s,%s %c.", lastName, firstName, middleName.charAt(0));
    }
}