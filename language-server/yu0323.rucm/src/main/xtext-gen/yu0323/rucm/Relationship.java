/**
 * generated by Xtext 2.19.0
 */
package yu0323.rucm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yu0323.rucm.Relationship#getActor <em>Actor</em>}</li>
 *   <li>{@link yu0323.rucm.Relationship#getUsecase <em>Usecase</em>}</li>
 * </ul>
 *
 * @see yu0323.rucm.RucmPackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends EObject
{
  /**
   * Returns the value of the '<em><b>Actor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actor</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actor</em>' reference.
   * @see #setActor(Actor)
   * @see yu0323.rucm.RucmPackage#getRelationship_Actor()
   * @model
   * @generated
   */
  Actor getActor();

  /**
   * Sets the value of the '{@link yu0323.rucm.Relationship#getActor <em>Actor</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actor</em>' reference.
   * @see #getActor()
   * @generated
   */
  void setActor(Actor value);

  /**
   * Returns the value of the '<em><b>Usecase</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Usecase</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Usecase</em>' reference.
   * @see #setUsecase(UseCase)
   * @see yu0323.rucm.RucmPackage#getRelationship_Usecase()
   * @model
   * @generated
   */
  UseCase getUsecase();

  /**
   * Sets the value of the '{@link yu0323.rucm.Relationship#getUsecase <em>Usecase</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Usecase</em>' reference.
   * @see #getUsecase()
   * @generated
   */
  void setUsecase(UseCase value);

} // Relationship
