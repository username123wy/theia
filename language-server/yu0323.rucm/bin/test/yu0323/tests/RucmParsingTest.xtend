/*
 * generated by Xtext 2.19.0
 */
package yu0323.tests

import yu0323.rucm.UCModel
import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(RucmInjectorProvider)
class RucmParsingTest {
	@Inject
	ParseHelper<UCModel> parseHelper
	
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			ucmodel example
			
			actor yuyue
			
			usecase drive
			usecase stop
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
	}
}