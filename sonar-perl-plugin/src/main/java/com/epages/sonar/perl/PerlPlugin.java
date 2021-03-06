package com.epages.sonar.perl;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import com.epages.sonar.perl.colorizer.PerlCodeColorizer;
import com.epages.sonar.perl.rules.PerlCritic;
import com.epages.sonar.perl.rules.PerlCriticIssuesLoaderSensor;
import com.epages.sonar.perl.rules.PerlCriticProfile;
import com.epages.sonar.perl.rules.PerlCriticRulesDefinition;

@Properties({ //
    @Property( //
    key = PerlPlugin.FILE_SUFFIXES_KEY, //
    name = "File Suffixes", //
    description = "Comma-separated list of suffixes for files to analyze.", //
    defaultValue = PerlPlugin.DEFAULT_FILE_SUFFIXES), //
    @Property( //
    key = PerlCritic.PERLCRITIC_REPORT_PATH_KEY, //
    name = "Perlcritic Report Location", //
    description = "Location of perlcritic report file. Needs to be generated using these command-line flags: --quiet --verbose \"%f~|~%s~|~%l~|~%c~|~%m~|~%e~|~%p~||~%n\"", //
    defaultValue = PerlCritic.PERLCRITIC_REPORT_PATH_DEFAULT ) //
})
public class PerlPlugin extends SonarPlugin {

    public static final String FILE_SUFFIXES_KEY = "com.epages.sonar.perl.suffixes";

    public static final String DEFAULT_FILE_SUFFIXES = "pm,pl,t";

    @SuppressWarnings("rawtypes")
    @Override
    public List getExtensions() {
        return Arrays.asList(
                PerlLanguage.class,
                PerlCriticRulesDefinition.class, 
                PerlCriticProfile.class,
                PerlCodeColorizer.class,
                GlobalSensor.class,
                PerlCriticIssuesLoaderSensor.class
        );
    }

}
