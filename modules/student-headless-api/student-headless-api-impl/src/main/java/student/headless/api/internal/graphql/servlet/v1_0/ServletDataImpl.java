package student.headless.api.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

import student.headless.api.internal.graphql.mutation.v1_0.Mutation;
import student.headless.api.internal.graphql.query.v1_0.Query;
import student.headless.api.internal.resource.v1_0.StudentResourceImpl;
import student.headless.api.resource.v1_0.StudentResource;

/**
 * @author USER
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setStudentResourceComponentServiceObjects(
			_studentResourceComponentServiceObjects);

		Query.setStudentResourceComponentServiceObjects(
			_studentResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "StudentHeadlessApi";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/student-headless-api-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#addStudent",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "addStudent"));
					put(
						"mutation#updateStudent",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "updateStudent"));
					put(
						"mutation#deleteStudent",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "deleteStudent"));
					put(
						"mutation#deleteStudentBatch",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "deleteStudentBatch"));

					put(
						"query#student",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "getStudent"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<StudentResource>
		_studentResourceComponentServiceObjects;

}