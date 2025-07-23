
import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros._
import java.time.Instant // For timestamp fields

package object generator {

  // --- Metadata Models ---
  case class Metadata(
    apiVersion: String,
    endpointPrefix: String,
    jsonVersion: String,
    protocol: String,
    protocols: List[String],
    serviceFullName: String,
    serviceId: String,
    signatureVersion: String,
    signingName: String,
    uid: String,
    auth: List[String] // Assuming auth is a list of strings like "aws.auth#sigv4"
  )
  object Metadata:
    given JsonValueCodec[Metadata] = {
      JsonCodecMaker.make
    }

  // --- Operation Models ---
  case class Http(
    method: String,
    requestUri: String,
    responseCode: Int
  )
  object Http:
    given JsonValueCodec[Http] = {
      JsonCodecMaker.make
    }

  case class ShapeRef(
    shape: String
  )
  object ShapeRef:
    given JsonValueCodec[ShapeRef] = {
      JsonCodecMaker.make
    }

  case class ErrorShapeRef(
    shape: String
  )
  object ErrorShapeRef:
    given JsonValueCodec[ErrorShapeRef] = {
      JsonCodecMaker.make
    }

  case class Operation(
    name: String,
    http: Http,
    input: ShapeRef,
    output: Option[ShapeRef] = None, // Output can be optional
    errors: Option[List[ErrorShapeRef]] = None, // Errors can be optional
    documentation: String,
    idempotent: Option[Boolean] = None // Idempotent is optional
  )
  object Operation:
    given JsonValueCodec[Operation] = {
      JsonCodecMaker.make
    }

  // --- Shape Models ---
  case class MemberDetail(
    shape: String,
    documentation: Option[String] = None,
    location: Option[String] = None, // For headers
    locationName: Option[String] = None,
    pattern: Option[String] = None,
    max: Option[Int] = None,
    min: Option[Int] = None,
    sensitive: Option[Boolean] = None,
    timestampFormat: Option[String] = None
  )
  object MemberDetail:
    given JsonValueCodec[MemberDetail] = {
      JsonCodecMaker.make
    }

  case class Shape(
    `type`: String, // 'type' is a keyword in Scala, so backticks are needed
    required: Option[List[String]] = None,
    members: Option[Map[String, MemberDetail]] = None, // Members are a map of fieldName -> MemberDetail
    documentation: Option[String] = None,
    `enum`: Option[List[String]] = None, // 'enum' is a keyword
    pattern: Option[String] = None,
    max: Option[Int] = None,
    min: Option[Int] = None,
    sensitive: Option[Boolean] = None,
    timestampFormat: Option[String] = None,
    error: Option[ErrorDetail] = None // For exception shapes
  )
  object Shape:
    given JsonValueCodec[Shape] = {
      JsonCodecMaker.make
    }

  case class ErrorDetail(
    httpStatusCode: Int,
    senderFault: Boolean
  )
  object ErrorDetail:
    given JsonValueCodec[ErrorDetail] = {
      JsonCodecMaker.make
    }

  // --- Top-level Service Definition Model ---
  case class ServiceDefinition(
    version: String,
    metadata: Metadata,
    operations: Map[String, Operation], // Operations are a map of operationName -> Operation
    shapes: Map[String, Shape] // Shapes are a map of shapeName -> Shape
  )
  object ServiceDefinition:
    given JsonValueCodec[ServiceDefinition] = {
      JsonCodecMaker.make
    }
}
