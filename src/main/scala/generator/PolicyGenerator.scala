package generator
import scala.collection.immutable.ListMap

/** Defines the interface for an AWS IAM Policy Generator. Implementations of
  * this trait will provide the logic for retrieving AWS service actions and
  * generating IAM policies.
  */
trait PolicyGenerator {

  /** Provides the underlying data mapping AWS service names to their available
    * actions. In a real system, this would likely be loaded from a more
    * comprehensive source like AWS Smithy models or a dynamic API.
    */
  protected val serviceActionData: ListMap[String, List[String]]

  /** Retrieves all available actions for a given set of AWS service names.
    *
    * @param serviceNames
    *   A Set of AWS service names (e.g., "S3", "EC2").
    * @return
    *   A Set of unique AWS action strings.
    */
  def getAvailableActionsForServices(serviceNames: Set[String]): Set[String] = {
    serviceNames.flatMap(serviceActionData.getOrElse(_, List.empty)).toSet
  }

  /** Generates an AWS IAM Policy JSON string based on a set of selected
    * actions.
    *
    * @param selectedActions
    *   A Set of AWS action strings (e.g., "s3:GetObject").
    * @param resource
    *   The ARN or wildcard for the resource. Defaults to "*" for simplicity. In
    *   a more advanced generator, this could be a list of ARNs or a more
    *   complex resource definition.
    * @return
    *   A JSON string representing the IAM policy, or an error message if no
    *   actions are selected.
    */
  def generateIamPolicy(
      selectedActions: Set[String],
      resource: String = "*"
  ): String

}
