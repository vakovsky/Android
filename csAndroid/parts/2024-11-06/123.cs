//1. Internal storage
//2. External storage
  //2.1 Public files
  //2.2 Private files

//Internal Storage
string dir1 = Application.Context.FilesDir.AbsolutePath;
string path1 = Path.Combine(dir1, "internal.txt");
File.WriteAllText(path1, "Internal storage");

//External – Private
//Java.IO.File dir2 = Application.Context.GetExternalFilesDir(null);
string dir2 = Application.Context.GetExternalFilesDir(null)?.AbsolutePath;
string path2 = Path.Combine(dir2, "private.txt");
File.WriteAllText(path2, "External private storage");

//External – Public
Java.IO.File dir3 = Android.OS.Environment.GetExternalStoragePublicDirectory(
    Android.OS.Environment.DirectoryDownloads
);
string path3 = Path.Combine(dir3.AbsolutePath, "public.txt");
File.WriteAllText(path3, "External public storage");


