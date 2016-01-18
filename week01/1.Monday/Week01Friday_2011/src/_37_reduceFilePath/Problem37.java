package _37_reduceFilePath;

public class Problem37  {
//ReduceFilePath
    public static String reduce_file_path(String path) {
        String[] s = path.split("/");
        // System.out.println("s: "+s.length);
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("..")) {
				s[i] = "";
				if (i > 0) {
					s[i - 1] = "";
				}
				// System.out.println("dve to4ki");
			}

			if (s[i].equals(".")) {
				s[i] = "";
			}
		}

        String shorterPath = "";
        for (int i = 0; i < s.length; i++)

        {
            // System.out.println("i:"+i+"s[i]:"+s[i]);
            if (!s[i].equals("")) {
                shorterPath += "/" + s[i];
            }
        }
        if (shorterPath.length() == 0)

        {
            return "/";
        } else
            return shorterPath;

    }

    public static void main(String[] args) {
        System.out.println(reduce_file_path("/home//radorado/code/./hackbulgaria/week0/../"));
        System.out.println(reduce_file_path("/"));// = "/"
        System.out.println(reduce_file_path("/srv/../"));// = "/"
        System.out.println(reduce_file_path("/srv/www/htdocs/wtf/"));// =
                                                                     // "/srv/www/htdocs/wtf"
        System.out.println(reduce_file_path("/srv/www/htdocs/wtf"));// =
                                                                    // "/srv/www/htdocs/wtf"
        System.out.println(reduce_file_path("/srv/./././././"));// = "/srv"
        System.out.println(reduce_file_path("/etc//wtf/"));// = "/etc/wtf"
        System.out.println(reduce_file_path("/etc/../etc/../etc/../"));// = "/"
        System.out.println(reduce_file_path("//////////////"));// = "/"
        System.out.println(reduce_file_path("/../"));// = "/"
    }
}

