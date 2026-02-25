public class Activity12 : Activity
{
    TextView textView1;
    public int SmsPermissionCode { get; private set; }
    protected override void OnCreate(Bundle savedInstanceState)
    {
        base.OnCreate(savedInstanceState);
        // Create your application here
        SetContentView(Resource.Layout.layout12);
        textView1 = FindViewById<TextView>(Resource.Id.textView1);
        if (ContextCompat.CheckSelfPermission(this, Manifest.Permission.ReadSms) != Permission.Granted)
        {
            ActivityCompat.RequestPermissions(this, new string[] { Manifest.Permission.ReadSms }, SmsPermissionCode);
        }
        else
        {
            ReadSms();
        }
    }
    private void ReadSms()
    {
        Uri uriSms = Uri.Parse("content://sms/inbox");
        ICursor cursor = ContentResolver.Query(uriSms, null, null, null, null);

        if (cursor != null && cursor.MoveToFirst())
        {
            StringBuilder sb = new StringBuilder();

            do
            {
                string body = cursor.GetString(cursor.GetColumnIndex("body"));
                string address = cursor.GetString(cursor.GetColumnIndex("address"));

                sb.AppendLine("От: " + address);
                sb.AppendLine("Съобщение: " + body);
                sb.AppendLine("-------------------");
            }
            while (cursor.MoveToNext());

            textView1.Text = sb.ToString();
            cursor.Close();
        }
    }
}
