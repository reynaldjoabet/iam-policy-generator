import scala.collection.immutable.ListMap
import scala.io.Source
import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros._
import generator.*
ListMap(
  "S3" -> List(
    "s3:GetObject",
    "s3:PutObject",
    "s3:DeleteObject",
    "s3:ListBucket",
    "s3:CreateBucket"
  ),
  "EC2" -> List(
    "ec2:DescribeInstances",
    "ec2:StartInstances",
    "ec2:StopInstances",
    "ec2:RunInstances",
    "ec2:TerminateInstances"
  ),
  "DynamoDB" -> List(
    "dynamodb:GetItem",
    "dynamodb:PutItem",
    "dynamodb:UpdateItem",
    "dynamodb:DeleteItem",
    "dynamodb:Scan",
    "dynamodb:Query"
  ),
  "Lambda" -> List(
    "lambda:InvokeFunction",
    "lambda:CreateFunction",
    "lambda:UpdateFunctionConfiguration",
    "lambda:DeleteFunction"
  ),
  "SQS" -> List(
    "sqs:SendMessage",
    "sqs:ReceiveMessage",
    "sqs:DeleteMessage",
    "sqs:ListQueues"
  ),
  "IAM" -> List(
    "iam:ListUsers",
    "iam:CreateUser",
    "iam:DeleteUser",
    "iam:AttachUserPolicy",
    "iam:PassRole"
  )
)


System.getProperty("java.class.path")

this.getClass().getResourceAsStream("/models/account/service-2.json")
 

val source="src/main/resources/models/account/service-2.json"
// extrac only operations from the service definition

Source.fromResource("models/account/service-2.json").getLines().mkString("\n")

//readFromString[ServiceDefinition](Source.fromResource("models/account/service-2.json").getLines().mkString("\n"))
