package murulidhar.armyofones;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by murulidhar on 8/9/2016.
 */
public class MainActivityTest  extends
        ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private EditText amount;
    private Button convertButton;
    private TextView gbpSum;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mainActivity = getActivity();
        amount = (EditText) mainActivity.findViewById(R.id.amount);
        convertButton = (Button) mainActivity.findViewById(R.id.convertButton);
        gbpSum = (TextView) mainActivity.findViewById(R.id.gbpSum);
    }

    @Test
    public void testPreconditions() {
        assertNotNull("mainActivity is null", mainActivity);
        assertNotNull("amount is null", amount);
        assertNotNull("convertButton is null", convertButton);
    }

    @UiThreadTest
    public void testAmount() {
        String value = "100";
        amount.setText(value);
        assertEquals("Values do not match", value, amount.getText().toString());
        convertButton.performClick();
        assertEquals("Values do not match", value, amount.getText().toString());
        assertNotNull("GbpSum null", gbpSum);
    }
}