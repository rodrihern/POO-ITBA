package examenes_viejos.pp_Repaso.Exam;

import java.util.Arrays;

public class LimitedExam extends UniqueExam {
    private final int maxStudents;
    private String[] pending;
    private int dim;
    private static final int DEFAULT_SIZE = 5;

    public LimitedExam(String name, int maxStudents) {
        super(name);
        dim = 0;
        pending = new String[DEFAULT_SIZE];
        this.maxStudents = maxStudents;
    }

    private void resize() {
        pending = Arrays.copyOf(pending, pending.length + DEFAULT_SIZE);
    }

    @Override
    public void enroll(String student) {
        if(getEnrolledCount() >= maxStudents) {
            if(dim == pending.length) {
                resize();
            }
            pending[dim++] = student;
            return;
        }
        super.enroll(student);
    }

    @Override
    public void unenroll(String student) {
        if(removeFromPending(student)) {
            return;
        }
        int dimBefore = getEnrolledCount();
        super.unenroll(student);
        if(dim > 0 && getEnrolledCount() < dimBefore) {
            enroll(pending[0]);
            System.arraycopy(pending, 1, pending, 0, --dim);
        }
    }

    private boolean removeFromPending(String student) {
        for(int i = 0; i < dim; i++) {
            if(pending[i].equals(student)) {
                System.arraycopy(pending, i+1, pending, i, --dim - i);
                return true;
            }
        }
        return false;
    }

    public String[] getPendingStudents() {
        return Arrays.copyOf(pending, dim);
    }


}
