package pl.wasat.smarthma.parser.missions.PotentialMissions;

import android.content.Context;

import java.util.ArrayList;

import pl.wasat.smarthma.parser.Parser.BaseParser;
import pl.wasat.smarthma.parser.Parser.Pair;
import pl.wasat.smarthma.parser.missions.SimpleMissionInterface;
import pl.wasat.smarthma.parser.model.Mission;
import pl.wasat.smarthma.parser.model.Page;

/**
 * Created by marcel on 2015-08-13.
 */
public class QuickBird2 extends BaseParser implements SimpleMissionInterface {
	public final static int MISSION_ID = 54;
	public final static String TITLE = "QuickBird-2";

	final int ITEMS_COUNT = 2;
	public QuickBird2(String pageUrl, Context context) {
		super(pageUrl, context);
		parserDb.addMission(new Mission(MISSION_ID, PotentialMissions.CATEGORY_ID, TITLE));

	}

	@Override
	public void mainContent() {
		super.getComplexPage(ITEMS_COUNT);
		ArrayList<Pair> list = super.getComplexPage(ITEMS_COUNT);
		for(Pair item : list){
			parserDb.addPage(new Page(PotentialMissions.CATEGORY_ID, MISSION_ID, (String)item.title,  (String)item.content ));
		}
	}
}
