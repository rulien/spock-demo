package no.kodemaker.server

import spock.lang.Specification
import org.junit.Rule
import org.junit.rules.TemporaryFolder


class JunitRuleTest extends Specification {
    @Rule def tempFolder = new TemporaryFolder()
    File file

    def "should create temp file in test and be gone after"(){
        setup :
            file = tempFolder.newFile("test")
        expect :
            file.exists()
    }

    def cleanup(){
        assert !file.exists()
    }
}
