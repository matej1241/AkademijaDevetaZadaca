package hr.ferit.brunozoric.taskie.di

import hr.ferit.brunozoric.taskie.domain.addTask.AddTaskUseCase
import hr.ferit.brunozoric.taskie.domain.addTask.AddTaskUseCaseImpl
import hr.ferit.brunozoric.taskie.domain.login.LoginUseCase
import hr.ferit.brunozoric.taskie.domain.login.LoginUseCaseImpl
import hr.ferit.brunozoric.taskie.domain.register.RegisterUseCase
import hr.ferit.brunozoric.taskie.domain.register.RegisterUseCaseImpl
import hr.ferit.brunozoric.taskie.domain.tasks.TasksUseCase
import hr.ferit.brunozoric.taskie.domain.tasks.TasksUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<LoginUseCase>{ LoginUseCaseImpl(get()) }
    factory<RegisterUseCase>{ RegisterUseCaseImpl(get()) }
    factory<TasksUseCase>{ TasksUseCaseImpl(get()) }
    factory<AddTaskUseCase>{ AddTaskUseCaseImpl(get()) }
}