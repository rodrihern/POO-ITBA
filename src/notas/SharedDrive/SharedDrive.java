package notas.SharedDrive;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class SharedDrive {
    ArrayList<SharedFile> files = new ArrayList<>();

    public static class SharedFile {
        private final String name, area;

        public SharedFile(String name, String area) {
            this.name = name;
            this.area = area;
        }

        @Override
        public String toString() {
            return "File %s in work area %s".formatted(name, area);
        }

        public String getFileName() {
            return name;
        }
    }


    public SharedDrive addFile(String name, String area) {
        files.add(new SharedFile(name, area));
        return this;
    }

    public Iterable<SharedFile> getAllFiles() {
        return new ArrayList<>(files);
    }

    public SharedFile getFirstFile(Predicate<SharedFile> predicate) {
        for(SharedFile sf : files) {
            if(predicate.test(sf)) {
                return sf;
            }
        }
        throw new NoSuchElementException();
    }

    public SharedFile getLastFile() {
        return files.getLast();
    }



}
